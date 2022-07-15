package com.example.madventure.composable.screen.onboarding.viewmodel

import androidx.lifecycle.ViewModel
import com.example.madventure.R
import com.example.madventure.model.dto.PagerItem

class OnBoardingViewModel: ViewModel() {
    val items = listOf<PagerItem>(
        PagerItem(R.drawable.pager_image_1, "Select the quest!", "A huge collection of different quests. Historical, children's, outdoors and many others..."),
        PagerItem(R.drawable.pager_image_2, "Complete the task!", "Search for secret keys, location detection, step counting and much more..."),
        PagerItem(R.drawable.pager_image_3, "Become a Top Key Finder", "User ratings, quest ratings, quest author ratings...")
    )
}