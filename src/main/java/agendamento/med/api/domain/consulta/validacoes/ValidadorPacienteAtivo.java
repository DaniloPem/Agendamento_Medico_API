package agendamento.med.api.domain.consulta.validacoes;

import agendamento.med.api.domain.consulta.DadosAgendamentoConsulta;
import agendamento.med.api.domain.consulta.ValidacaoException;
import agendamento.med.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo) {
           throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
