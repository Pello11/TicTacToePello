package com.example.tictactoepello

import android.content.Intent
import android.graphics.Color.WHITE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable

class MainActivity : AppCompatActivity() {

    var mtr: ArrayList<Button> = ArrayList()
    val BTN: String ="btn"
    var cnt = 0
    lateinit var textView: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startGame()
    }

    fun startGame(){

        var extras = intent.extras
        var name1 = extras?.getString("Name_1") ?: "Pippo"
        println("######################   Player: ${name1}")
        var name2 = extras?.getString("Name_2") ?: "Pluto"
        println("######################   Player: ${name2}")

        var id: Int

        for (i in 1..9)
        {
            id = resources.getIdentifier(BTN+"$i", "id", packageName)
            mtr.add(findViewById(id)) //ritrorna Button in automatico perchè Kotlin lo riconosce
        }

        for(i in mtr) {
            i.setOnClickListener {
                if(it is Button) btnControl(it)

                if(it is Button) {

                    var check = matchVictory(it.text as String)

                    if (check && it.text as String == "X"){
                        val intent = Intent(this, SecondActivity::class.java).apply {
                            putExtra("player", name1)
                        }
                        startActivity(intent)
                        finish()
                    } else if (check && it.text as String == "O"){
                        val intent = Intent(this, SecondActivity::class.java).apply {
                            putExtra("player", name2)
                        }
                        startActivity(intent)
                        finish()
                    } else if(cnt==9 && !check){
                        val intent = Intent(this, SecondActivity::class.java).apply {
                            putExtra("player", "none")
                        }
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }

    }

    fun btnControl(btn: Button)
    {
        if( cnt % 2 != 0 ) {btn.text = "O"} else {btn.text = "X"}
        btn.isActivated = false
        if(cnt < 9) cnt += 1
    }

    fun matchVictory(s: String): Boolean{

        if(match(mtr[0],s) && match(mtr[1],s) && match(mtr[2],s)){ return true}
        if(match(mtr[3],s) && match(mtr[4],s) && match(mtr[5],s)){ return true}
        if(match(mtr[6],s) && match(mtr[7],s) && match(mtr[8],s)){ return true}

        if(match(mtr[0],s) && match(mtr[3],s) && match(mtr[6],s)){ return true}
        if(match(mtr[1],s) && match(mtr[4],s) && match(mtr[7],s)){ return true}
        if(match(mtr[2],s) && match(mtr[5],s) && match(mtr[8],s)){ return true}

        if(match(mtr[0],s) && match(mtr[4],s) && match(mtr[8],s)){ return true}
        if(match(mtr[2],s) && match(mtr[4],s) && match(mtr[6],s)){ return true}

        return false
    }

    private fun match(button: Button, s: String): Boolean = button.text == s

}