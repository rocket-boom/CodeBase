package reactorLearning.myFlux;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/**
 * @author 饶珂
 * @date 2021/4/13 22:51
 */
public abstract class Flux<T> implements Publisher<T> {
    public abstract void subscribe(Subscriber<? super T> subscriber) ;

    public static <T> Flux<T> just(T... data){
        return new FluxArray<T>(data);
    }
}
