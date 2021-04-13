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
            public void onSubscribe(Subscription subscription) {
                System.out.println("start subscribe");
                subscription.request(6);
            }

            public void onNext(Integer integer) {
                System.out.println("Next -> " + integer);
            }

            public void onError(Throwable throwable) {

            }

            public void onComplete() {
                System.out.println("Task Complete!");
            }
        });
    }
}
