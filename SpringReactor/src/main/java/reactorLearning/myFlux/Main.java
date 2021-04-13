package reactorLearning.myFlux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author 饶珂
 * @date 2021/4/13 22:58
 */
public class Main {
    public static void main(String[] args) {
        Flux.just(1,2,3,4,5,6).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("start subscribe");
                subscription.request(6);
            }
            @Override
            public void onNext(Integer integer) {
                System.out.println("Next -> " + integer);
            }

            @Override
            public void onError(Throwable throwable) {

            }
            @Override
            public void onComplete() {
                System.out.println("Task Complete!");
            }
        });
    }
}
