import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Driver(
    val firstName: String,
    val lastName: String,
    val driverPhoto: Int,
    val driverPhotoDetail: Int,
    val driverTeam: String,
    val driverChamp: Int,
    val driverPodium: Int,
    val driverCountry: String,
    val driverFlag: Int,
    val driverDesc: String
) : Parcelable