package tech.noir.app.bills.navigation.presentation.components

import tech.noir.app.bills.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int
) {
    object Home :
        BottomNavItem(
            "Home",
            R.drawable.grid
        )

    object List :
        BottomNavItem(
            "Bills",
            R.drawable.bills
        )

    object Analytics :
        BottomNavItem(
            "Scan",
            R.drawable.scan
        )

    object Profile :
        BottomNavItem(
            "Profile",
            R.drawable.profile
        )
}