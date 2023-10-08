package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
private var mcurrentanswer:Int=0
    private var mUserName: String?=null

    private var progressbar:ProgressBar?=null
    private var progress:TextView?=null
    private var tvquestion:TextView?=null
    private var image:ImageView?=null

    private var optionone:TextView?=null
    private var optiontwo:TextView?=null
    private var optionthree:TextView?=null
    private var optionfour:TextView?=null
    private var btnsubmit:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        progressbar=findViewById(R.id.progressbar)
        progress=findViewById(R.id.progress)
        tvquestion=findViewById(R.id.question)
        image=findViewById(R.id.image)
        mUserName=intent.getStringExtra(constants.USER_NAME)
        optionone=findViewById(R.id.option1)
        optiontwo=findViewById(R.id.option2)
        optionthree=findViewById(R.id.option3)
        optionfour=findViewById(R.id.option4)
        btnsubmit=findViewById(R.id.btnsubmit)
         mQuestionsList=constants.getquestion()
         optionone?.setOnClickListener(this)
        optiontwo?.setOnClickListener(this)
        optionthree?.setOnClickListener(this)
        optionfour?.setOnClickListener(this)
        btnsubmit?.setOnClickListener(this)
        setQuestion(mQuestionsList)

    }

    private fun setQuestion(questionlist: ArrayList<Question>?) {
        defaultoptions()
        var currentposition = 1
        val question: Question = questionlist!![mCurrentPosition - 1]
        image?.setImageResource(question.image)
        progressbar?.progress = mCurrentPosition
        progress?.text = "$mCurrentPosition/${progressbar?.max}"
        tvquestion?.text = question.question
        optionone?.text = question.optionone
        optiontwo?.text = question.optiontwo
        optionthree?.text = question.optionthree
        optionfour?.text = question.optionfour
        if(mCurrentPosition==mQuestionsList!!.size){
            btnsubmit?.text="Finish"
        }else{
            btnsubmit?.text="Next"
        }
    }

    private fun defaultoptions(){
        val options=ArrayList<TextView>()
        optionone?.let{
           options.add(0,it)
        }

        optiontwo?.let{
            options.add(1,it)
        }

        optionthree?.let{
            options.add(2,it)
        }

        optionfour?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.defaultborder)
        }
    }

    private fun selectedview(tv:TextView,selectedOptionNum:
    Int){
        defaultoptions()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option1->{
                optionone?.let{
                    selectedview(it,1)
                }
            }
            R.id.option2->{
                optiontwo?.let{
                    selectedview(it,2)
                }
            }
            R.id.option3->{
                optionthree?.let{
                    selectedview(it,3)
                }
            }
            R.id.option4->{
                optionfour?.let{
                    selectedview(it,4)
                }
            }
            R.id.btnsubmit->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionsList!!.size->{
                            setQuestion(mQuestionsList)
                        }
                        else->{
                            val intent= Intent(this,Result::class.java)
                            intent.putExtra(constants.USER_NAME,mUserName)
                            intent.putExtra(constants.CORRECT_ANSWER,mcurrentanswer)
                            intent.putExtra(constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question =mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.answer!=mSelectedOptionPosition){
                        answerview(mSelectedOptionPosition,R.drawable.wrongdefaultborder)
                    }else{
                        mcurrentanswer++
                    }
                    answerview(question.answer,R.drawable.correctdefaultborder)
                    if(mCurrentPosition==mQuestionsList!!.size){
                        btnsubmit?.text="FINISH"
                    }else{
                        btnsubmit?.text="GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition=0
                }


            }
        }
    }
    private fun answerview(answer:Int,drawable: Int){
        when(answer){
            1->{
                optionone?.background=ContextCompat.getDrawable(
                    this,drawable
                )
            }
            2->{
                optiontwo?.background=ContextCompat.getDrawable(
                    this,drawable
                )
            }
            3->{
                optionthree?.background=ContextCompat.getDrawable(
                    this,drawable
                )
            }
            4->{
                optionfour?.background=ContextCompat.getDrawable(
                    this,drawable
                )
            }
        }
    }
}