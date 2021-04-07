package org.owntracks.android.gms.location

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.owntracks.android.location.LocationRequest
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class LocationRequestGMSConversion {

    @Test
    fun canConvertLocationRequestToGMS() {
        val locationRequest = LocationRequest()
                .setFastestInterval(1000)
                .setInterval(30_000)
                .setNumUpdates(50)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setExpirationDuration(TimeUnit.MINUTES.toMillis(2))
                .setSmallestDisplacement(50f)

        val gmsLocationRequest = locationRequest.toGMSLocationRequest()
        assertEquals(1000, gmsLocationRequest.fastestInterval)
        assertEquals(30_000, gmsLocationRequest.interval)
        assertEquals(50, gmsLocationRequest.numUpdates)
        assertEquals(com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY, gmsLocationRequest.priority)
        assertEquals(50f, gmsLocationRequest.smallestDisplacement)
        assertTrue(gmsLocationRequest.isFastestIntervalExplicitlySet)
    }
}