package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id来删除对应的口味数据
     * @param id
     */
    @Delete("delete  from  dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long id);

    /**
     * 根据菜品Id集合，批量删除关联的口味集合
     * @param ids
     */
    void deleteByDishIds(List<Long> ids);

    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);
}
