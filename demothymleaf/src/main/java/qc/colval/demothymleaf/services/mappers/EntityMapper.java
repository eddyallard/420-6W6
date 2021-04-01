package qc.colval.demothymleaf.services.mappers;

public interface EntityMapper<T,D> {
    D entityToDto(T t);
}
