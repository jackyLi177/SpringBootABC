package com.Utils.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ian @Description: CollectionUtils
 * @date 18-3-31下午3:41
 */
public class CollectionUtils {
  /**
   * 初始化一个Map
   *
   * @return
   */
  public static <K, V> Map<K, V> newHashMap(K key, V value) {
    Map<K, V> res = new HashMap<>();
    res.put(key, value);
    return res;
  }
}
