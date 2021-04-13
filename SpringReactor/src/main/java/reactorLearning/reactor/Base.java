package reactorLearning.reactor;

import lombok.SneakyThrows;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author 饶珂
 * @date 2021/4/13 23:08
 */
public class Base {
    @SneakyThrows
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1,2,3,4,5);
        flux.map(i -> i*i )
                .flatMap(s->Flux.just(s*s))
                .subscribe(System.out::println,
                        System.err::println,
                        () -> { System.out.println("Complete!"); });

        Mono<Integer> mono = Mono.just(1);
        System.out.println(Thread.currentThread().getName());
        mono.flatMap(e->{
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);

            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            return Mono.just(e);
        }).subscribeOn(Schedulers.elastic())
                .subscribe(System.out::println);
        Thread.sleep(2000);
    }
}
