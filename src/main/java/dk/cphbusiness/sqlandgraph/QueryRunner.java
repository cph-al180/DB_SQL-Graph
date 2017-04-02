package dk.cphbusiness.sqlandgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QueryRunner {

    public static void main(String[] args) {
        testConnectors();
    }

    private static void testConnectors() {
        GraphConnector gc = new GraphConnector();
        MySQLConnector mc = new MySQLConnector();
        Random random = new Random();
        List<String> allNames = gc.getAllNames();
        List<String> randomNames = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            randomNames.add(allNames.get(random.nextInt(allNames.size())));
        }

        System.out.println("Depth One");
        testEndorsementDepthOneGraph(gc, randomNames);
        testEndorsementDepthOneMySQL(mc, randomNames);
        System.out.println("\nDepth Two");
        testEndorsementDepthTwoGraph(gc, randomNames);
        testEndorsementDepthTwoMySQL(mc, randomNames);
        System.out.println("\nDepth Three");
        testEndorsementDepthThreeGraph(gc, randomNames);
        testEndorsementDepthThreeMySQL(mc, randomNames);
        System.out.println("\nDepth Four");
        testEndorsementDepthFourGraph(gc, randomNames);
        testEndorsementDepthFourMySQL(mc, randomNames);
        System.out.println("\nDepth Five");
        testEndorsementDepthFiveGraph(gc, randomNames);
        testEndorsementDepthFiveMySQL(mc, randomNames);
    }

    private static void calcAvarageTime(List<Long> results) {
        long sum = 0;
        for (Long result : results) {
            sum += result;
        }
        long avarage = sum / results.size();
        System.out.println("Avarage: " + avarage);
    }

    private static void testEndorsementDepthOneGraph(GraphConnector gc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            gc.personEndorsementDepthOne(name);
            //System.out.println(gc.personEndormentDepthOne(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + gc.getName());
        calcAvarageTime(results);
    }

    private static void testEndorsementDepthTwoGraph(GraphConnector gc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            gc.personEndorsementDepthTwo(name);
            //System.out.println(gc.personEndormentDepthTwo(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + gc.getName());
        calcAvarageTime(results);
    }

    private static void testEndorsementDepthThreeGraph(GraphConnector gc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            gc.personEndorsementDepthThree(name);
            //System.out.println(gc.personEndormentDepthThree(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + gc.getName());
        calcAvarageTime(results);
    }

    private static void testEndorsementDepthFourGraph(GraphConnector gc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            gc.personEndorsementDepthFour(name);
            //System.out.println(gc.personEndormentDepthFour(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + gc.getName());
        calcAvarageTime(results);
    }

    private static void testEndorsementDepthFiveGraph(GraphConnector gc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            gc.personEndorsementDepthFive(name);
            //System.out.println(gc.personEndormentDepthFive(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + gc.getName());
        calcAvarageTime(results);
    }

    private static void testEndorsementDepthOneMySQL(MySQLConnector mc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            mc.personEndorsementDepthOne(name);
            //System.out.println(mc.personEndorsementDepthOne(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + mc.getName());
        calcAvarageTime(results);
    }

    private static void testEndorsementDepthTwoMySQL(MySQLConnector mc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            mc.personEndorsementDepthTwo(name);
            //System.out.println(mc.personEndorsementDepthTwo(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + mc.getName());
        calcAvarageTime(results);
    }

    private static void testEndorsementDepthThreeMySQL(MySQLConnector mc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            mc.personEndorsementDepthThree(name);
            //System.out.println(mc.personEndorsementDepthThree(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + mc.getName());
        calcAvarageTime(results);
    }
    
    private static void testEndorsementDepthFourMySQL(MySQLConnector mc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            mc.personEndorsementDepthFour(name);
            //System.out.println(mc.personEndorsementDepthFour(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + mc.getName());
        calcAvarageTime(results);
    }
    
    private static void testEndorsementDepthFiveMySQL(MySQLConnector mc, List<String> randomNames) {
        List<Long> results = new ArrayList<>();
        for (String name : randomNames) {
            long start = System.currentTimeMillis();
            mc.personEndorsementDepthFive(name);
            //System.out.println(mc.personEndorsementDepthFive(name));
            long end = System.currentTimeMillis();
            results.add(end - start);
        }
        System.out.println("Result for: " + mc.getName());
        calcAvarageTime(results);
    }

}
