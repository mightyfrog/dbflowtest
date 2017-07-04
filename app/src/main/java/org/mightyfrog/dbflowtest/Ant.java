package org.mightyfrog.dbflowtest;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * @author Shigehiro Soejima
 */
@Table(database = AppDatabase.class)
public class Ant extends BaseModel {
    @PrimaryKey(autoincrement = true)
    public long id;

    @ForeignKey(stubbedRelationship = true)
    Food food;

    @ForeignKey(stubbedRelationship = true)
    Queen queen;

    @Column
    public String name;

    @Column
    public int age;

    @Override
    public String toString() {
        return "Ant{" +
                "id=" + id +
                ", food=" + food +
                ", queen=" + queen +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
