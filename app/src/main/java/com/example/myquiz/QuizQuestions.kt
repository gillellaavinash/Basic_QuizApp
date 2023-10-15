package com.example.myquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class QuizQuestions : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var selectedPosition : Int =0
    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0
    private var choosen: Int =0

    private var progressBar : ProgressBar? = null
    private var txtProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var optionOne : TextView? = null
    private var optionTwo : TextView? = null
    private var optionThree : TextView? = null
    private var optionFour : TextView? = null
    private var btnSubmit : Button? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        txtProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.img_view)

        optionOne = findViewById(R.id.btn_one)
        optionTwo = findViewById(R.id.btn_two)
        optionThree = findViewById(R.id.btn_three)
        optionFour = findViewById(R.id.btn_four)
        btnSubmit = findViewById(R.id.btnSubmit)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        mQuestionList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        txtProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question

        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size)
        {
            btnSubmit?.text="FINISH"
        }
        else
        {
            btnSubmit?.text="SUBMIT"
        }
    }

    private fun defaultOptionsView()
    {
        val options = ArrayList<TextView>()

        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }

        for(i in options)
        {
            i.setTextColor(Color.parseColor("#d6ccc2"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptions(tv : TextView , selectedOptionsNum : Int) {
         defaultOptionsView()

        selectedPosition = selectedOptionsNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onClick(view: View?) {

         when(view?.id){
             R.id.btn_one ->{
                 btnSubmit?.isVisible = true
                 optionOne?.let {
                     selectedOptions(it,1)
                     choosen++
                 }
                 choosen++
             }
             R.id.btn_two ->{
                 btnSubmit?.isVisible = true
                 optionTwo?.let {
                     selectedOptions(it,2)
                 }
                 choosen++
             }
             R.id.btn_three ->{
                 btnSubmit?.isVisible = true
                 optionThree?.let {
                     selectedOptions(it,3)
                 }
                 choosen++
             }
             R.id.btn_four ->{
                 btnSubmit?.isVisible = true
                 optionFour?.let {
                     selectedOptions(it,4)
                 }
                 choosen++
             }
             R.id.btnSubmit ->{
                 if(selectedPosition == 0)
                 {
                     btnSubmit?.isVisible = false
                     mCurrentPosition++
                     when{
                         mCurrentPosition <= mQuestionList!!.size ->{
                             setQuestion()
                         }
                         else ->{
                             val intent = Intent(this , ResultActivity:: class.java)
                             intent.putExtra(Constants.USER_NAME , mUserName)
                             intent.putExtra(Constants.CORRECT_ANSWER , mCorrectAnswers)
                             intent.putExtra(Constants.TOTAL_QUESTIONS , progressBar?.max)
                             startActivity(intent)
                             finish()
                         }
                     }
                 }
                 else{
                     val question = mQuestionList?.get(mCurrentPosition-1)
                       if(question!!.correctAnswer != selectedPosition)
                       {
                        answerView(selectedPosition,R.drawable.wrong_option_border_bg)
                       }
                     else{
                         mCorrectAnswers++
                       }
                     answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                     if(mCurrentPosition == mQuestionList!!.size)
                     {
                         btnSubmit?.text="FINISH"
                     }
                     else {
                         btnSubmit?.text = "GO TO NEXT QUESTION"
                     }

                     choosen=0
                     selectedPosition=0
                     R.drawable.default_option_border_bg
                 }
             }
         }
    }

    private fun answerView(answer : Int , drawableView : Int)
    {
        when(answer) {
            1->{
                optionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                optionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                optionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                optionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}