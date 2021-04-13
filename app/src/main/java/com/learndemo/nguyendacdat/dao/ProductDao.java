package com.learndemo.nguyendacdat.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.learndemo.nguyendacdat.entity.ProductEntity;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface ProductDao {

    @Insert(onConflict = REPLACE)
    void insertProduct(ProductEntity product);

//    @Update
//    void updateProduct(ProductEntity product);
//
//    @Delete
//    void deleteProduct(ProductEntity product);

    @Query("SELECt * FROM Product")
    List<ProductEntity> getAllProduct();
}
