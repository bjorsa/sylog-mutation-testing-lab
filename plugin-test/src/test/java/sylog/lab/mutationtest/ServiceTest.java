package sylog.lab.mutationtest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

    @Test
    public void add_0_0() {
        assertThat(new Service().add(0, 0)).isEqualTo(0);
    }
}