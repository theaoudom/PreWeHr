package com.hrd.wehr_project.consts
import com.hrd.wehr_project.R
import java.util.Objects

sealed class Screen(val route: String,val icon: Int? = null,val iconSelected: Int? = null, val title: String? = null) {
    data object Summary : Screen("Summary", R.drawable.summary_icon,R.drawable.summary_icon_selected, "Summary")
    data object Attendance : Screen("Attendance", R.drawable.attendance_icon,R.drawable.attendance_icon_selected, "Attendance")
    data object Leave : Screen("Leave", R.drawable.leave_icon,R.drawable.leave_icon_selected, "Leave")
    data object Overtime : Screen("Overtime", R.drawable.overtime_icon,R.drawable.overtime_icon_selected, "Overtime")

    data object Login : Screen("Login")
}
val bottomNavItem = listOf(
    Screen.Summary,
    Screen.Attendance,
    Screen.Leave,
    Screen.Overtime
)

sealed class AllOvertimeScreen(val route: String) {
    object RequestOTScreen : AllOvertimeScreen("RequestOTScreen")
    object OvertimeDetailScreen : AllOvertimeScreen("OvertimeDetailScreen")
    object EditOvertimeScreen : AllOvertimeScreen("EditOvertimeScreen")
}
