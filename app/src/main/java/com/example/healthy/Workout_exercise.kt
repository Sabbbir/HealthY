package com.example.healthy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.healthy.databinding.ActivityWorkoutExerciseBinding

class Workout_exercise : AppCompatActivity() {

    private var binding : ActivityWorkoutExerciseBinding? = null

    private var restTimer : CountDownTimer?= null
    private var restProgress=0
     private var exerciseTimer : CountDownTimer?= null
    private var exerciseProgress=0

    private var exerciseList : ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarex)

        if(supportActionBar!= null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        exerciseList = Constant.defaultExerciseList()

        binding?.toolbarex?.setNavigationOnClickListener {
            onBackPressed()
        }
        seRestView()
    }
    private fun seRestView(){
        binding?.progressbarExercise?.visibility = View.VISIBLE
        binding?.tvTitle?.visibility = View.VISIBLE
        binding?.tvExercise?.visibility  = View.INVISIBLE
        binding?.flExerciseProgressbar?.visibility = View.INVISIBLE
        binding?.ivImage?.visibility = View.INVISIBLE
        binding?.upcomingEx?.visibility = View.VISIBLE
        binding?.upcomingExName?.visibility = View.VISIBLE
        binding?.upcomingExName?.text = exerciseList!![currentExercisePosition+1].getName()

        if(restTimer!=null){
            restTimer?.cancel()
            restProgress = 0

        }
        setRestProgressBar()
            }
    private fun setUpExView(){
        binding?.progressbarExercise?.visibility = View.INVISIBLE
        binding?.tvTitle?.visibility = View.INVISIBLE
        binding?.tvExercise?.visibility  = View.VISIBLE
        binding?.flExerciseProgressbar?.visibility = View.VISIBLE
        binding?.ivImage?.visibility = View.VISIBLE
        binding?.upcomingEx?.visibility = View.INVISIBLE
        binding?.upcomingExName?.visibility = View.INVISIBLE

        if(exerciseTimer!= null){
            exerciseTimer?.cancel()
            exerciseProgress=0
        }

        binding?.ivImage?.setImageResource(exerciseList!![currentExercisePosition].getImage())
        binding?.tvExercise?.text = exerciseList!![currentExercisePosition].getName()
        setExerciseProgressBar()
    }

    private fun setRestProgressBar(){
        binding?.progressbarExercise?.progress = restProgress
        restTimer = object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding?.progressbarExercise?.progress = 10- restProgress
                binding?.tvtimerExercise?.text = (10- restProgress).toString()
            }

            override fun onFinish() {
                currentExercisePosition++
                setUpExView()
                  }

        }.start()
    }


    private fun setExerciseProgressBar(){
        binding?.progressbarExerciseEx?.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(50000,1000){
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                binding?.progressbarExerciseEx?.progress = 50- exerciseProgress
                binding?.tvtimerExerciseEx?.text = (50- exerciseProgress).toString()
            }

            override fun onFinish() {
            if(currentExercisePosition < exerciseList?.size!!-1 ){
                seRestView()
            }
                else{
                    Toast.makeText(this@Workout_exercise,"Congratulations! Exercise Completed!",
                    Toast.LENGTH_SHORT).show()
            }
            }

        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer!=null){
            restTimer?.cancel()
            restProgress = 0

        }
        if(exerciseTimer!= null){
            exerciseTimer?.cancel()
            exerciseProgress=0
        }
        binding = null
    }
}