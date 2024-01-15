package agendamento.med.api.domain.consulta;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensages) {
        super(mensages);
    }
}
