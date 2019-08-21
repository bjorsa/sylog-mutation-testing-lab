package sylog.lab.mutationtest.domain;

import sylog.lab.mutationtest.domain.util.Validate;

import java.util.UUID;

public final class Identifier extends ValueObject {

    private final UUID uuid;

    public Identifier() {
        this(UUID.randomUUID());
    }

    public Identifier(String uuid) {
        this(UUID.fromString(uuid));
    }

    public Identifier(UUID uuid) {
        Validate.notNull(uuid, () -> new NullPointerException("uuid can't be null."));
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
