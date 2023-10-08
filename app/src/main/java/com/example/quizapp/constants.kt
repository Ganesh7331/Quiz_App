package com.example.quizapp

object constants {
    const val USER_NAME: String="user_name"
    const val TOTAL_QUESTIONS: String="total_question"
    const val CORRECT_ANSWER:String="correct_answer"
    fun getquestion(): ArrayList<Question>?{
        val questionlist=ArrayList<Question>()
        val que1= Question(1,"What country does this country belong to?",R.drawable.ic_flag_of_argentina,
        "Argentina","Australia","Austria","Poland",1
            )
        val que2= Question(2,"What country does this country belong to?",R.drawable.ic_flag_of_australia,
            "America","Australia","Britain","Canada",2
        )
        val que3= Question(3,"What country does this country belong to?",R.drawable.ic_flag_of_belgium,
            "Germany","Belgium","Netherlands","Turkey",2
        )
        val que4= Question(4,"What country does this country belong to?",R.drawable.ic_flag_of_brazil,
            "Argentina","Chili","France","Brazil",4
        )
        val que5= Question(5,"What country does this country belong to?",R.drawable.ic_flag_of_denmark,
            "Poland","Denmark","Austria","Spain",2
        )
        val que6= Question(6,"What country does this country belong to?",R.drawable.ic_flag_of_fiji,
            "En","Australia","Austria","Fiji",4
        )
        val que7= Question(7,"What country does this country belong to?",R.drawable.ic_flag_of_germany,
            "Spain","Australia","Germany","Poland",3
        )
        val que8= Question(8,"What country does this country belong to?",R.drawable.ic_flag_of_india,
            "India","Portugal","Spain","Hungary",1
        )
        val que9= Question(9,"What country does this country belong to?",R.drawable.ic_flag_of_kuwait,
            "Armenia","Iraq","Kuwait","Azarbhaijan",3
        )
        val que10= Question(10,"What country does this country belong to?",R.drawable.ic_flag_of_new_zealand,
            "America","Australia","New_Zealand","England",3
        )
        questionlist.add(que1)
        questionlist.add(que2)
        questionlist.add(que3)
        questionlist.add(que4)
        questionlist.add(que5)
        questionlist.add(que6)
        questionlist.add(que7)
        questionlist.add(que8)
        questionlist.add(que9)
        questionlist.add(que10)

        return questionlist
    }
}