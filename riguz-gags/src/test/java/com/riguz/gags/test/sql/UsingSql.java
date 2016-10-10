package com.riguz.gags.test.sql;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riguz.gags.sql.Condition;
import com.riguz.gags.sql.Query;
import com.riguz.gags.sql.Query.QUERY;

public class UsingSql {
    @Test
    public void usingArgument(){
        Query s1 = Query.build(new Condition("name", QUERY.EQUAL, "riguz"));
        assertEquals("AND `name` = ?", s1.getSql().trim());
        assertEquals("riguz", s1.getParams().get(0));
    }
}
