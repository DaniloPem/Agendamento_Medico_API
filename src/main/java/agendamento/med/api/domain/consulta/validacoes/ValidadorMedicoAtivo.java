package agendamento.med.api.domain.consulta.validacoes;

import agendamento.med.api.domain.consulta.DadosAgendamentoConsulta;
import agendamento.med.api.domain.consulta.ValidacaoException;
import agendamento.med.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {
    private MedicoRepository repository;
    public void validar(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico exluído");
        }
    }
}
