package com.example.android.quizzkotlin

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_quiz.*

class quiz : AppCompatActivity() {



    internal var j = "Japan"
    internal var j1 = "JAPAN"
    internal var j2 = "japan"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


    }


    fun getResults(view: View) {

        val rightcheck = right1.isChecked()
        val editAnswer = edit.getText().toString()
        //play sound when button clicked
        val mp = MediaPlayer.create(this, R.raw.switchon)

        mp.start()

        val txt = findViewById<EditText>(R.id.name)
        val nameValue = txt.text.toString()


        if (TextUtils.isEmpty(txt.text)) {
            /**
             * You can Toast a message here that the Username is Empty
             */

            txt.error = "First name is required!"

            /*Error toast*/
            val resetMessage = Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG)
            resetMessage.show()
            /*scroll to the top*/
            val scrollToTop = findViewById<View>(R.id.scrollview) as ScrollView
            scrollToTop.fullScroll(ScrollView.FOCUS_UP)

        } else {


            /*
        creates an array of answers
         */
            val answerArray: BooleanArray
            answerArray = BooleanArray(10)
            var answer = findViewById<View>(R.id.answer_1) as RadioButton
            answerArray[0] = answer.isChecked
            answer = findViewById<View>(R.id.answer_2) as RadioButton
            answerArray[1] = answer.isChecked
            answer = findViewById<View>(R.id.answer_3) as RadioButton
            answerArray[2] = answer.isChecked
            answer = findViewById<View>(R.id.answer_4) as RadioButton
            answerArray[3] = answer.isChecked
            answer = findViewById<View>(R.id.answer_5) as RadioButton
            answerArray[4] = answer.isChecked
            answer = findViewById<View>(R.id.answer_6) as RadioButton
            answerArray[5] = answer.isChecked
            answer = findViewById<View>(R.id.answer_7) as RadioButton
            answerArray[6] = answer.isChecked
            answer = findViewById<View>(R.id.answer_8) as RadioButton
            answerArray[7] = answer.isChecked


            /*score calculation*/
            val score = calculateScore(answerArray, editAnswer)

            var  resultMessage = "-"

            resultMessage = resultSummary(score, nameValue)

            /*displaying score*/
            displayScore(resultMessage)

            // display score as toast message
            val scoreMessage = Toast.makeText(this, "your score = " + score.toString() + " out of 10", Toast.LENGTH_LONG)
            scoreMessage.show()
        }
    }


    private fun resultSummary(score: Int, nameValue: String): String {
        var resultMessage = getString(R.string.examiner_name, nameValue)
        resultMessage += "\n" + getString(R.string.score, score)
        resultMessage += "\n" + getString(R.string.thank_you)
        return resultMessage

    }

    /*
   method calculating the overall score
    */
    private fun calculateScore(scoreArray: BooleanArray, editAnswer: String): Int {
        var methodScore = 0
        for (i in 0..8) {
            if (scoreArray[i]) {
                methodScore += 1
            }
        }

        if (editAnswer == j || editAnswer == j1 || editAnswer == j2) {
            methodScore += 1
        }



        if (wrong1.isChecked || wrong2.isChecked) {

            return methodScore

        } else if (right1.isChecked && right2.isChecked) {
            methodScore += 1
        }


        return methodScore
    }


    private fun displayScore(message: String) {
        val resultText = findViewById<View>(R.id.result_display) as TextView
        resultText.text = message
    }


    fun resetQuiz(view: View) {
        /*
         this part scrolls the screen back to the top of the view
         */
        val scrollToTop = findViewById<View>(R.id.scrollview) as ScrollView
        scrollToTop.fullScroll(ScrollView.FOCUS_UP)
        /*
        this part resets the RadioGroups
        */
        var choiceGroup = findViewById<View>(R.id.radioGroup1) as RadioGroup
        choiceGroup.clearCheck()
        choiceGroup = findViewById<View>(R.id.radioGroup2) as RadioGroup
        choiceGroup.clearCheck()
        choiceGroup = findViewById<View>(R.id.radioGroup3) as RadioGroup
        choiceGroup.clearCheck()
        choiceGroup = findViewById<View>(R.id.radioGroup4) as RadioGroup
        choiceGroup.clearCheck()
        choiceGroup = findViewById<View>(R.id.radioGroup5) as RadioGroup
        choiceGroup.clearCheck()
        choiceGroup = findViewById<View>(R.id.radioGroup6) as RadioGroup
        choiceGroup.clearCheck()
        choiceGroup = findViewById<View>(R.id.radioGroup7) as RadioGroup
        choiceGroup.clearCheck()


        // to clear the edit text field
        edit.setText("")

        //to check the right answers
        right1.isChecked = false
        right2.isChecked = false
        wrong1.isChecked = false
        wrong2.isChecked = false
        /*informative toast*/
        val resetMessage = Toast.makeText(this, getString(R.string.reset), Toast.LENGTH_LONG)
        resetMessage.show()

        //play sound when button clicked
        val mp = MediaPlayer.create(this, R.raw.switchon)

        mp.start()


    }


    /*
      * method that will show the user the correct answers
      * */
    fun correctAnswers(view: View) {

        //play sound when button clicked
        val mp = MediaPlayer.create(this, R.raw.switchon)

        mp.start()

        /*
         this part scrolls the screen back to the top of the view
         */
        val scrollToTop = findViewById<View>(R.id.scrollview) as ScrollView
        scrollToTop.fullScroll(ScrollView.FOCUS_UP)
        /*
        * this part sets the radio buttons for each RadioGroup to correct answer
        * */

        var choiceGroup = findViewById<View>(R.id.radioGroup1) as RadioGroup
        choiceGroup.check(R.id.answer_1)
        choiceGroup = findViewById<View>(R.id.radioGroup2) as RadioGroup
        choiceGroup.check(R.id.answer_2)
        choiceGroup = findViewById<View>(R.id.radioGroup3) as RadioGroup
        choiceGroup.check(R.id.answer_3)
        choiceGroup = findViewById<View>(R.id.radioGroup4) as RadioGroup
        choiceGroup.check(R.id.answer_4)
        choiceGroup = findViewById<View>(R.id.radioGroup5) as RadioGroup
        choiceGroup.check(R.id.answer_5)
        choiceGroup = findViewById<View>(R.id.radioGroup6) as RadioGroup
        choiceGroup.check(R.id.answer_6)
        choiceGroup = findViewById<View>(R.id.radioGroup7) as RadioGroup
        choiceGroup.check(R.id.answer_7)


        //to write the answer in the edit text field
        edit.setText(j1)

        //to check the right answers
        right1.isChecked = true
        right2.isChecked = true
        wrong1.isChecked = false
        wrong2.isChecked = false

        //informative toast
        val infoMessage = Toast.makeText(this, getString(R.string.rightanswers), Toast.LENGTH_LONG)
        infoMessage.show()
    }


}
