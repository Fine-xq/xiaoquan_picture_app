package cn.edu.sicnu.cs.stu.xiaoquan.myapplication_second

class ProgramAdviser {
    fun getAnswer(input:String):String{
        return when(input.trim()){
            "java" -> "Java是面向对象语言"
            "kotlin" -> "Kotlin是Android推荐开发语言"
            else -> "暂无匹配答案"
        }
    }
}
