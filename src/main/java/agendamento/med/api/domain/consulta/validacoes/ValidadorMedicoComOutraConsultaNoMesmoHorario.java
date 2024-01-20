package agendamento.med.api.domain.consulta.validacoes;

import agendamento.med.api.domain.consulta.ConsultaRepository;
import agendamento.med.api.domain.consulta.DadosAgendamentoConsulta;
import agendamento.med.api.domain.consulta.ValidacaoException;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedico(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
