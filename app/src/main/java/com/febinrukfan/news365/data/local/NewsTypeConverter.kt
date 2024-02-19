package com.febinrukfan.news365.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.febinrukfan.news365.domain.model.Source


/**
 * Created by Febin Rukfan on 2024-02-19.
 * febinrukfan@gmail.com
 */
@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun sourceToString(source: Source): String{
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String): Source{
        return source.split(',').let { sourceArray ->
            Source(id = sourceArray[0], name = sourceArray[1])
        }
    }
}