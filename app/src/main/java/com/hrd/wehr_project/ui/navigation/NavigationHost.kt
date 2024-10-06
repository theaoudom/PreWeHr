package com.hrd.wehr_project.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hrd.wehr_project.consts.Screen
import com.hrd.wehr_project.ui.screen.attendance.AttendanceScreen
import com.hrd.wehr_project.ui.screen.auth.LoginScreen
import com.hrd.wehr_project.ui.screen.leave.LeaveScreen
import com.hrd.wehr_project.ui.screen.overtime.OvertimeScreen
import com.hrd.wehr_project.ui.screen.summary.SummaryScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Summary.route){
        composable(Screen.Summary.route){
            SummaryScreen()
        }
        composable(Screen.Attendance.route){
            AttendanceScreen()
        }
        composable(Screen.Leave.route){
            LeaveScreen()
        }
        composable(Screen.Overtime.route){
            OvertimeScreen()
        }
        composable(Screen.Login.route){
            LoginScreen()
        }
    }
}