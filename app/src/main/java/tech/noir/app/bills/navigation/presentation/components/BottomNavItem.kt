package tech.noir.app.bills.navigation.presentation.components

import tech.noir.app.bills.R
import tech.noir.app.bills.navigation.domain.ROUTE_HOME
import tech.noir.app.bills.navigation.domain.ROUTE_BILLS
import tech.noir.app.bills.navigation.domain.ROUTE_SCAN
import tech.noir.app.bills.navigation.domain.ROUTE_PROFILE

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var route: String
) {
    object Home :
        BottomNavItem(
            "Home",
            R.drawable.grid,
            ROUTE_HOME
        )

    object Bills :
        BottomNavItem(
            "Bills",
            R.drawable.bills,
            ROUTE_BILLS
        )

    object Scan :
        BottomNavItem(
            "Scan",
            R.drawable.scan,
            ROUTE_SCAN
        )

    object Profile :
        BottomNavItem(
            "Profile",
            R.drawable.profile,
            ROUTE_PROFILE
        )
}