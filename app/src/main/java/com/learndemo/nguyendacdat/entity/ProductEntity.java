package com.learndemo.nguyendacdat.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product")
public class ProductEntity {

    @PrimaryKey(autoGenerate = true)
    public int Id;

    @ColumnInfo(name = "Name")
    public String Name;

    @ColumnInfo(name = "Quantity")
    public int Quantity;
}
