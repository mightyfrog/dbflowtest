package org.mightyfrog.dbflowtest;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * @author Shigehiro Soejima
 */
@Table(database = AppDatabase.class)
public class Food extends BaseModel {
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String name;

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
