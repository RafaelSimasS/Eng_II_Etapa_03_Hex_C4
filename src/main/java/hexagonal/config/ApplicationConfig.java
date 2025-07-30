package hexagonal.config;

import hexagonal.adapters.out.repositories.mapper.JogoMapper;
import hexagonal.adapters.out.repositories.mapper.JogoPlataformaMapper;
import hexagonal.adapters.out.repositories.mapper.PlataformaMapper;
import hexagonal.core.domain.service.LocacaoService;
import hexagonal.core.domain.usecase.*;
import hexagonal.ports.in.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import hexagonal.ports.out.ClienteRepositoryPort;
import hexagonal.ports.out.JogoPlataformaRepositoryPort;
import hexagonal.ports.out.LocacaoRepositoryPort;

@Configuration
public class ApplicationConfig {

    @Bean
    public JogoMapper jogoMapper() {
        return new JogoMapper();
    }

    @Bean
    public PlataformaMapper plataformaMapper() {
        return new PlataformaMapper();
    }

    @Bean
    public JogoPlataformaMapper jogoPlataformaMapper(JogoMapper jogoMapper,
                                                     PlataformaMapper plataformaMapper) {
        return new JogoPlataformaMapper(jogoMapper, plataformaMapper);
    }

    @Bean
    public LocacaoService servicoDeLocacao(ClienteRepositoryPort clienteRepo,
                                           LocacaoRepositoryPort locacaoRepo,
                                           JogoPlataformaRepositoryPort jogoPlatRepo) {
        return new LocacaoService(clienteRepo, locacaoRepo, jogoPlatRepo);
    }

    @Bean
    public CriarLocacaoInputPort criarLocacaoUseCase(LocacaoService servico) {
        return new CriarLocacaoUseCase(servico);
    }

    @Bean
    public InserirJogoLocacaoInputPort inserirJogoLocacaoUseCase(LocacaoService servico) {
        return new InserirJogoLocacaoUseCase(servico);
    }

    @Bean
    public CalcularCustoTotalLocacaoInputPort calcularCustoTotalLocacaoUseCase(LocacaoService servico) {
        return new CalcularCustoTotalLocacaoUseCase(servico);
    }

    @Bean
    public CreateClienteInputPort createClienteUseCase(ClienteRepositoryPort repo) {
        return new CreateClienteUseCase(repo);
    }

    @Bean
    public GetClienteInputPort getClienteUseCase(ClienteRepositoryPort repo) {
        return new GetClienteUseCase(repo);
    }

    @Bean
    public UpdateClienteInputPort updateClienteUseCase(ClienteRepositoryPort repo) {
        return new UpdateClienteUseCase(repo);
    }

    @Bean
    public DeleteClienteInputPort deleteClienteUseCase(ClienteRepositoryPort repo) {
        return new DeleteClienteUseCase(repo);
    }




}
