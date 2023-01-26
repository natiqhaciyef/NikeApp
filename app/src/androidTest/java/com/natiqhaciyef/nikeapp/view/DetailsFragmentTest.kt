package com.natiqhaciyef.nikeapp.view

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.natiqhaciyef.nikeapp.launchFragmentInHiltContainer
import com.natiqhaciyef.nikeapp.presentation.view.fragment.home.DetailsFragment
import com.natiqhaciyef.nikeapp.R
import com.natiqhaciyef.nikeapp.presentation.view.fragment.home.DetailsFragmentDirections
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

/** View testinglərdəki nüanslar
 * UI testingdə əsasən Fragmentlər arası navigation test olunur. Bu testingdə heç bir
 * binding texnologiyası istifadə olunmamalıdıir. Əks halda xəta baş verəcək. Əlavə olaraq
 * test olunan zaman digər fragmentlərdən test olunan fragmentə heç bir navigation
 * arguments gəlməməlidir.
 * Qeyd: Fragment testinglər UI testing hesab olunur ki bu səbəbdən test zamanı MediumTest
 * ve HiltAndroidTest yazılması şərtdir. Qeyd etmək lazımdırki, launchFragmentInHiltContainer()
 * funksiyası Google Android Developers tərəfindən təklif olunan Hilt-ə uyğunlaşdırılmış Fragment
 * testləri üçün hazır Navigation funksiyasıdır.
 * */

@MediumTest
@HiltAndroidTest
class DetailsFragmentTest {
    @get: Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setup(){
        hiltAndroidRule.inject()
    }

    @Test
    fun navigationFromHomeToUserProfile(){
        val navController = Mockito.mock(NavController::class.java)
        launchFragmentInHiltContainer<DetailsFragment>{
            Navigation.setViewNavController(requireView(), navController)
        }
        Espresso.onView(ViewMatchers.withId(R.id.addToCartButton)).perform(ViewActions.click())
        Mockito.verify(navController).navigate(R.id.cartFragment)
    }
}