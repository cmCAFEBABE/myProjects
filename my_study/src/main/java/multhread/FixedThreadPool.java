/**
 * @(#)ThreadPool.java, 2020-08-05.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package multhread;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */


/**
 * 注意：
 * feature.get()方法会阻塞当前线程直到线程完成
 */

public class FixedThreadPool {

    @Test
    public void testFixedThreadPool() {

        ExecutorService pool = Executors.newFixedThreadPool(100);
        List<Future<Integer>> results = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            Integer ii = Integer.valueOf(i);
            Future<Integer> feature = pool.submit(() -> {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().toString());
                System.out.println(ii);
                return ii;
            });
//            sout(feature);
            results.add(feature);
        }

        System.out.println("-------------------------");
        results.stream().forEach(o->{
            try {
                System.out.println(o.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }

    private void sout(Future o){
        try{
            System.out.println(o.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}