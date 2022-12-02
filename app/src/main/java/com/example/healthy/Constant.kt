package com.example.healthy

object Constant {
    fun defaultExerciseList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()

        val onePlank = ExerciseModel(1, " Elbow Plank", R.drawable.one_plank, false, false)
        exerciseList.add(onePlank)

        val twoPlankRotation = ExerciseModel(2, "Plank Rotation", R.drawable.two_plank_rotation, false, false)
        exerciseList.add(twoPlankRotation)

        val threeSidePlank = ExerciseModel(3, "Side Plank", R.drawable.three_sideplank, false, false)
        exerciseList.add(threeSidePlank)

        val fourKneePlank = ExerciseModel(4, "Knee Pusshup", R.drawable.four_knee_pushup, false, false)
        exerciseList.add(fourKneePlank)

        val fivePushUp = ExerciseModel(5, "Push Up", R.drawable.five_pushup, false, false)
        exerciseList.add(fivePushUp)

        val sixSpidermanPushup= ExerciseModel(6, "Spiderman Pushup", R.drawable.six_spiderman_pushup, false, false)
        exerciseList.add(sixSpidermanPushup)

        val sevenSquat= ExerciseModel(7, "Squats", R.drawable.seven_squat, false, false)
        exerciseList.add(sevenSquat)

        val eightBurpeeSquatThurst= ExerciseModel(8, "Burpee Squat Thurst", R.drawable.eight_burpee_squat_thurst, false, false)
        exerciseList.add(eightBurpeeSquatThurst)

        val nineHollowHold= ExerciseModel(9, "Hollow Hold", R.drawable.nine_hollowhold, false, false)
        exerciseList.add(nineHollowHold)

        val tenWallsit= ExerciseModel(10, "Wallsit", R.drawable.ten_wallsit, false, false)
        exerciseList.add(tenWallsit)

        val elevenLunge= ExerciseModel(11, "Lunge", R.drawable.eleven_lunge, false, false)
        exerciseList.add(elevenLunge)

        val twelveJumpingJacks= ExerciseModel(12, "Jumping Jacks", R.drawable.twelve_jumping_jacks, false, false)
        exerciseList.add(twelveJumpingJacks)

        return exerciseList
    }
}