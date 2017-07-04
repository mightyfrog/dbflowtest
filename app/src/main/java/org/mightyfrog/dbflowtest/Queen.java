package org.mightyfrog.dbflowtest;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * @author Shigehiro Soejima
 */
@Table(database = AppDatabase.class)
public class Queen extends BaseModel {
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String name;

    List<Ant> ants;

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "ants")
    List<Ant> getMyAnts() {
        if (ants == null || ants.isEmpty()) {
            ants = SQLite.select()
                    .from(Ant.class)
                    .where(Ant_Table.queen_id.eq(id))
                    .queryList();
        }
        return ants;
    }

    @Override
    public String toString() {
        return "Queen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ants=" + ants +
                '}';
    }
}
