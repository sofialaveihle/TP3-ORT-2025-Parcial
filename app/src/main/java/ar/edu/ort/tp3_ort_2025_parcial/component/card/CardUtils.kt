package ar.edu.ort.tp3_ort_2025_parcial.component.card

import androidx.compose.runtime.Composable
import ar.edu.ort.tp3_ort_2025_parcial.R

data class NotificationInfo(
    val image: Int,
    val text: String,
    val text2: String,
    val endImage: Int?,
)

private fun getActivityInfo() : List<NotificationInfo> {
    return listOf(
        NotificationInfo(R.drawable.product_notification2, "SALE 50%", "Check the details!", null),
        NotificationInfo(R.drawable.product_notification2, "SALE 50%", "Check the details!", null),
        NotificationInfo(R.drawable.product_notification2, "SALE 50%", "Check the details!", null),
        NotificationInfo(R.drawable.product_notification2, "SALE 50%", "Check the details!", null)
    )
}

@Composable
fun ActivityContent(){
    val activityInfo = getActivityInfo()
    activityInfo.forEach { item ->
        NotificationCard1(item.image, item.text, item.text2, item.endImage)
    }
}

private fun getSellerModeInfo() : List<NotificationInfo> {
    return listOf(
        NotificationInfo(R.drawable.product_notification2, "You Got New Order!", "Please arrange delivery", null),
        NotificationInfo(R.drawable.user_notification, "Momon", "Liked your Product", R.drawable.product_notification2),
        NotificationInfo(R.drawable.user_notification2, "Ola", "Liked your Product", R.drawable.product_notification2),
        NotificationInfo(R.drawable.user_notification, "Momon", "Liked your Product", R.drawable.product_notification2),
        NotificationInfo(R.drawable.product_notification2, "You Got New Order!", "Please arrange delivery", null),
        NotificationInfo(R.drawable.product_notification2, "You Got New Order!", "Please arrange delivery", null),
        NotificationInfo(R.drawable.product_notification2, "You Got New Order!", "Please arrange delivery", null),
        NotificationInfo(R.drawable.user_notification2, "Ola", "Liked your Product", R.drawable.product_notification2),
        )
}

@Composable
fun SellerModeContent(){
    val activityInfo = getSellerModeInfo()
    activityInfo.forEach { item ->
        NotificationCard1(item.image, item.text, item.text2, item.endImage)
    }
}