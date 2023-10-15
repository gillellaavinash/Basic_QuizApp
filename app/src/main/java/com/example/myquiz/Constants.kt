package com.example.myquiz

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWER : String = "correct_answer"

    fun getQuestions() : ArrayList<Question>{

        val questionsList =ArrayList<Question>()
        val que1 = Question(
            1,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "India",
            "Japan",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            2,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_australia,
            "Armenia",
            "Australia",
            "Indonesia",
            "Kuwait",
            2
        )
        questionsList.add(que2)

        val que3 = Question(
            3,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_belgium,
            "Brazil",
            "NewZealand",
            "Fiji",
            "Belgium",
            4
        )
        questionsList.add(que3)

        val que4 = Question(
            4,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_brazil,
            "India",
            "Australia",
            "Brazil",
            "Fiji",
            3
        )
        questionsList.add(que4)

        val que5 = Question(
            5,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_denmark,
            "NewZealand",
            "Denmark",
            "Argentina",
            "South Korea",
            2
        )
        questionsList.add(que5)

        val que6 = Question(
            6,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_fiji,
            "Belgium",
            "Bosnia",
            "Fiji",
            "Germany",
            3
        )
        questionsList.add(que6)

        val que7 = Question(
            7,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Australia",
            "Pakistan",
            "Brazil",
            1
        )
        questionsList.add(que7)

        val que8 = Question(
            8,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_new_zealand,
            "NewZealand",
            "Australia",
            "Japan",
            "Kuwait",
            1
        )
        questionsList.add(que8)

        val que9 = Question(
            9,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_india,
            "Brazil",
            "Fiji",
            "India",
            "Kuwait",
            3
        )
        questionsList.add(que9)

        val que10 = Question(
            10,"Which Country does this flag belong to ?",
            R.drawable.ic_flag_of_kuwait,
            "Syria",
            "Kuwait",
            "Germany",
            "Qatar",
            2
        )
        questionsList.add(que10)


        return questionsList
    }

}