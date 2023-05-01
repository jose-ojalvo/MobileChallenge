package com.jojalvo.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.jojalvo.entity.user.*

/**
 *   @author jojalvo
 *   @since 27/4/23
 *   @email josealejandro025@gmail.com
 */

class NameConverter {
    @TypeConverter
    fun fromName(name: Name): String {
        return "${name.title}|${name.first}|${name.last}"
    }

    @TypeConverter
    fun toName(nameString: String): Name {
        val split = nameString.split("|")
        return Name(split[0], split[1], split[2])
    }
}

class StreetConverter {
    @TypeConverter
    fun fromStreet(street: Street): String {
        return "${street.number}/${street.name}"
    }

    @TypeConverter
    fun toStreet(streetString: String): Street {
        val split = streetString.split("/")
        return Street(split[0].toInt(), split[1])
    }
}

class CoordinatesConverter {
    @TypeConverter
    fun fromCoordinates(coordinates: Coordinates): String {
        return "${coordinates.latitude}/${coordinates.longitude}"
    }

    @TypeConverter
    fun toCoordinates(coordinatesString: String): Coordinates {
        val split = coordinatesString.split("/")
        return Coordinates(split[0], split[1])
    }
}

class TimezoneConverter {
    @TypeConverter
    fun fromTimezone(timezone: Timezone): String {
        return "${timezone.offset}/${timezone.description}"
    }

    @TypeConverter
    fun toTimezone(timezoneString: String): Timezone {
        val split = timezoneString.split("/")
        return Timezone(split[0], split[1])
    }
}

class LocationConverter {
    @TypeConverter
    fun fromLocation(location: Location): String {
        return StreetConverter().fromStreet(location.street) + "|" +
                "${location.city}|" +
                "${location.state}|" +
                "${location.country}|" +
                "${location.postcode}|" +
                CoordinatesConverter().fromCoordinates(location.coordinates) + "|" +
                TimezoneConverter().fromTimezone(location.timezone) + "|"
    }

    @TypeConverter
    fun toLocation(locationString: String): Location {
        val split = locationString.split("|")
        return Location(
            StreetConverter().toStreet(split[0]),
            split[1],
            split[2],
            split[3],
            split[4],
            CoordinatesConverter().toCoordinates(split[5]),
            TimezoneConverter().toTimezone(split[6])
        )
    }
}

class DobConverter {
    @TypeConverter
    fun fromDob(dob: Dob): String {
        return "${dob.date}|${dob.age}"
    }

    @TypeConverter
    fun toDob(dobString: String): Dob {
        val split = dobString.split("|")
        return Dob(split[0], split[1].toInt())
    }
}

class PictureConverter {
    @TypeConverter
    fun fromPicture(picture: Picture): String {
        return "${picture.large}|${picture.medium}|${picture.thumbnail}"
    }

    @TypeConverter
    fun toPicture(pictureString: String): Picture {
        val split = pictureString.split("|")
        return Picture(split[0], split[1], split[2])
    }
}
