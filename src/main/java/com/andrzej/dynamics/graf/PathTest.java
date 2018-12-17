package com.andrzej.dynamics.graf;

//import static org.testng.Assert.*;

import org.testng.Assert;

/**
 * Created by farbanie_1115092 on 10.12.18.
 */
public class PathTest {
//    @org.testng.annotations.Test
    public void testBuildGraph() throws Exception {

    }

    @org.testng.annotations.Test
    public void testDecompress() throws Exception {
        Path p = new Path();
        String code = "pie(2*3)s";
        String decoded = p.decompress(code);
        Assert.assertEquals(decoded, "pieieieies");
    }

}