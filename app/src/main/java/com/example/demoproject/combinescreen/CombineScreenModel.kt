package com.example.demoproject.combinescreen

import android.app.Activity
import android.webkit.WebView
import android.widget.RelativeLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.example.demoproject.*
import com.example.demoproject.TabLayout.TabLayoutDemo
import com.example.demoproject.activityintent.ActivityCamera
import com.example.demoproject.activityintent.ActivityImplicitIntent
import com.example.demoproject.activityintent.ActivityOne
import com.example.demoproject.activityintent.ActivityTwo
import com.example.demoproject.activityintent.appdrawer.ActivityNavAppDrawer
import com.example.demoproject.activityintent.fragments.ActivityFragments
import com.example.demoproject.activityintent.navgraph.ActivityBottomNavGraph
import com.example.demoproject.activityintent.navgraph.ActivityNavGraph
import com.example.demoproject.customview.CustomViewDemo
import com.example.demoproject.ktscreen.HomeMarkKTScreenFragment
import com.example.demoproject.ktscreen.LivingRoomScreenFragment
import com.example.demoproject.ktscreen.LivingRoomTempScreen
import com.example.demoproject.layouts.*
import com.example.demoproject.recyclerview.*
import com.example.demoproject.recyclerview.kt.ChatFragment
import com.example.demoproject.roomdb.ui.InsertUserActivity
import com.example.demoproject.screens.CartFragment
import com.example.demoproject.screens.DetailShoes
import com.example.demoproject.screens.HomePageFragment
import com.example.demoproject.searchview.ActivitySearchView
import com.example.demoproject.webservices.ActivityDisplayUser
import com.example.demoproject.webservices.newsapp.ui.ActivityNews
import com.example.demoproject.webservices.ui.*
import com.example.demoproject.webview.ActivityWebView

data class CombineScreenModel(
    val name: String,
    val clazz: Class<out Activity>? = null,
    val fragment: Fragment? = null,
    val type: ComponentType?
) {
    val a = ButtonDemo()
    companion object {
        fun getAllComponents() : List<CombineScreenModel> {
            return listOf(
                CombineScreenModel("UIWidgets", type = ComponentType.HEADER),
                CombineScreenModel("Button", fragment = ButtonDemo(), type = ComponentType.BODY),
                CombineScreenModel("TextFiled", fragment = TextInputLayoutDemo(), type = ComponentType.BODY),
                CombineScreenModel("Toast", fragment = ToastDemo(), type = ComponentType.BODY),
                CombineScreenModel("ToggleButton", fragment = ToggleButtonDemo(), type = ComponentType.BODY),
                CombineScreenModel("CheckBox", fragment = CheckBoxDemo(), type = ComponentType.BODY),
                CombineScreenModel("RadioButton", fragment = RadioGroupDemo(), type = ComponentType.BODY),
                CombineScreenModel("SnackBar", fragment = SnackBarDemo(), type = ComponentType.BODY),
                CombineScreenModel("Spinner", fragment = SpinnerDemo(), type = ComponentType.BODY),
                CombineScreenModel("Chips", fragment = ChipsDemo(), type = ComponentType.BODY),
                CombineScreenModel("TabLayout", fragment = TabLayoutDemo(), type = ComponentType.BODY),
                CombineScreenModel("CustomView", fragment = CustomViewDemo(), type = ComponentType.BODY),
                CombineScreenModel("Screens", type = ComponentType.HEADER),
                CombineScreenModel("Cart Screen", fragment = CartFragment(), type = ComponentType.BODY),
                CombineScreenModel("Details Shoes Screen", fragment = DetailShoes(), type = ComponentType.BODY),
                CombineScreenModel("HomePage Screen", fragment = HomePageFragment(), type = ComponentType.BODY),
                CombineScreenModel("KT Screens", type = ComponentType.HEADER),
                CombineScreenModel("HomeMart Screen", fragment = HomeMarkKTScreenFragment(), type = ComponentType.BODY),
                CombineScreenModel("LivingRoom Screen", fragment = LivingRoomScreenFragment(), type = ComponentType.BODY),
                CombineScreenModel("LivingRoom Temperature Screen", fragment = LivingRoomTempScreen(), type = ComponentType.BODY),

                CombineScreenModel("Layouts", type = ComponentType.HEADER),
                CombineScreenModel("RelativeLayout", fragment = RelativeLayout(), type = ComponentType.BODY),
                CombineScreenModel("GridLayout Demo", fragment = GridLayoutDemo(), type = ComponentType.BODY),
                CombineScreenModel("Constraint Layout Chain", fragment = ConstraintLayoutChain(), type = ComponentType.BODY),
                CombineScreenModel("Coordinator Layout Fab button Demo", fragment = CoordinatorDemoFabButton(), type = ComponentType.BODY),
                CombineScreenModel("Coordinator Layout Toolbar Demo", fragment = CorrdinatorLayoutFragment(), type = ComponentType.BODY),

                CombineScreenModel("RecyclerView", fragment = ButtonDemo(), type = ComponentType.HEADER),
                CombineScreenModel("Songs with Pagination", fragment = SongFragment(), type = ComponentType.BODY),
                CombineScreenModel("Expandable", fragment = ExpandableRecyclerView(), type = ComponentType.BODY),
                CombineScreenModel("Different Views", fragment = MovieSeriesFragment(), type = ComponentType.BODY),
                CombineScreenModel("Shoes", fragment = ShoesGridRecyclerView(), type = ComponentType.BODY),
                CombineScreenModel("LivingRoom Screen", fragment = LivingRoomRecyclerView(), type = ComponentType.BODY),
                CombineScreenModel("BottomNavigation ViewPager", fragment = BottomNavigationViewPager(), type = ComponentType.BODY),
                CombineScreenModel("Chat Screen", fragment = ChatFragment(), type = ComponentType.BODY),

                CombineScreenModel("Activity, Fragment, Intent", fragment = ButtonDemo(), type = ComponentType.HEADER),
                CombineScreenModel("Data Pass Between Activities", clazz = ActivityOne::class.java, type = ComponentType.BODY),
                CombineScreenModel("Implicit Intent", clazz = ActivityImplicitIntent::class.java, type = ComponentType.BODY),
                CombineScreenModel("Camera Practical", clazz = ActivityCamera::class.java, type = ComponentType.BODY),
                CombineScreenModel("Fragments", clazz = ActivityFragments::class.java, type = ComponentType.BODY),

                CombineScreenModel("Navigation", type = ComponentType.HEADER),
                CombineScreenModel("Navigation Graph", clazz = ActivityNavGraph::class.java, type = ComponentType.BODY),
                CombineScreenModel("BottomNavigation with Navigation", clazz = ActivityBottomNavGraph::class.java, type = ComponentType.BODY),
                CombineScreenModel("AppDrawer with Navigation", clazz = ActivityNavAppDrawer::class.java, type = ComponentType.BODY),

                CombineScreenModel("OtherViews", type = ComponentType.HEADER),
                CombineScreenModel("WebView", clazz = ActivityWebView::class.java, type = ComponentType.BODY),
                CombineScreenModel("SearchView", clazz = ActivitySearchView::class.java, type = ComponentType.BODY),

                CombineScreenModel("Retrofit", type = ComponentType.HEADER),
                CombineScreenModel("Retro fit Get Request", clazz = ActivityDisplayUser::class.java, type = ComponentType.BODY),
                CombineScreenModel("Login Post request", clazz = ActivityLogin::class.java, type = ComponentType.BODY),
                CombineScreenModel("Retrofit All Request Demo", clazz = ActivityDisplayMockApiUsers::class.java, type = ComponentType.BODY),
                CombineScreenModel("OkHttp getuser", clazz = ActivityDisplayUserOkHttp::class.java, type = ComponentType.BODY),
                CombineScreenModel("OkHttp Registration", clazz = AddUserOkHttp::class.java, type = ComponentType.BODY),
                CombineScreenModel("Upload Image", clazz = ActivityUploadImage::class.java, type = ComponentType.BODY),
                CombineScreenModel("Download Image", clazz = ActivityDownloadFile::class.java, type = ComponentType.BODY),
                CombineScreenModel("Permission and News App", clazz = ActivityNews::class.java, type = ComponentType.BODY),

                CombineScreenModel("RoomDB", clazz = InsertUserActivity::class.java, type = ComponentType.BODY),
            )
        }
    }
}