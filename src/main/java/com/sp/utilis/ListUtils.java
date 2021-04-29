package com.sp.utilis;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This abstract class extends {@link CollectionUtils}.
 *
 * Note: The user of this class should not create a function that already exists in {@link CollectionUtils}
 * The main goal of this class is to regroup all the utilities methods for List and Stream
 *
 * @author imad.berkati
 * @version 1
 */
public abstract class ListUtils extends CollectionUtils {

    /**
     * Remove all null elements from a List
     *
     * @param list {@link List <T>} List to filter
     * @return The filtered List
     */
    public static <T> List<T> removeNulls(List<T> list) {
        if (isNotEmpty(list)) {
            return list.stream().filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    /**
     * Remove all null elements from a Stream
     *
     * @param stream {@link Stream <T>} Stream to filter
     * @return The filtered List
     */
    public static <T> List<T> removeNulls(Stream<T> stream) {
        if (stream != null) {
            return stream.filter(Objects::nonNull).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}