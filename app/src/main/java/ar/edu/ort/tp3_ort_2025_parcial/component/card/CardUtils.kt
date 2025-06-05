package ar.edu.ort.tp3_ort_2025_parcial.component.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ar.edu.ort.tp3_ort_2025_parcial.R

data class NotificationInfo(
    val image: Int,
    val text: String,
    val text2: String,
    val endImage: Int?,
)

@Composable
private fun getActivityInfo() : List<NotificationInfo> {
    return listOf(
        NotificationInfo(R.drawable.product_notification2, text = stringResource(R.string.sale), text2 = stringResource(R.string.check_details), null),
        NotificationInfo(R.drawable.product_notification2, text = stringResource(R.string.sale), text2 = stringResource(R.string.check_details), null),
        NotificationInfo(R.drawable.product_notification2, text = stringResource(R.string.sale), text2 = stringResource(R.string.check_details), null),
        NotificationInfo(R.drawable.product_notification2, text = stringResource(R.string.sale), text2 = stringResource(R.string.check_details), null)
    )
}

@Composable
fun ActivityContent(){
    val activityInfo = getActivityInfo()
    activityInfo.forEach { item ->
        NotificationCard1(item.image, item.text, item.text2, item.endImage)
    }
}

@Composable
private fun getSellerModeInfo() : List<NotificationInfo> {
    return listOf(
        NotificationInfo(R.drawable.product_notification2, text = stringResource(R.string.new_order), text2 = stringResource(R.string.arrange_delivery), null),
        NotificationInfo(R.drawable.user_notification, text = stringResource(R.string.momon), text2 = stringResource(R.string.like), R.drawable.product_notification2),
        NotificationInfo(R.drawable.user_notification2, text = stringResource(R.string.ola), text2 = stringResource(R.string.like), R.drawable.product_notification2),
        NotificationInfo(R.drawable.user_notification, text = stringResource(R.string.momon), text2 = stringResource(R.string.like), R.drawable.product_notification2),
        NotificationInfo(R.drawable.product_notification2, text = stringResource(R.string.new_order), text2 = stringResource(R.string.arrange_delivery), null),
        NotificationInfo(R.drawable.product_notification2, text = stringResource(R.string.new_order), text2 = stringResource(R.string.arrange_delivery), null),
        NotificationInfo(R.drawable.product_notification2, text = stringResource(R.string.new_order), text2 = stringResource(R.string.arrange_delivery), null),
        NotificationInfo(R.drawable.user_notification2, text = stringResource(R.string.ola), text2 = stringResource(R.string.like), R.drawable.product_notification2),
        )
}

@Composable
fun SellerModeContent(){
    val activityInfo = getSellerModeInfo()
    activityInfo.forEach { item ->
        NotificationCard1(item.image, item.text, item.text2, item.endImage)
    }
}