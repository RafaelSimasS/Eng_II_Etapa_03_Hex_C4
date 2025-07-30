package hexagonal.config;

import hexagonal.adapters.out.repositories.mapper.JogoMapper;
import hexagonal.adapters.out.repositories.mapper.JogoPlataformaMapper;
import hexagonal.adapters.out.repositories.mapper.PlataformaMapper;
import hexagonal.core.domain.service.ClienteService;
import hexagonal.core.domain.service.JogoPlataformaService;
import hexagonal.core.domain.service.LocacaoService;
import hexagonal.core.domain.service.PlataformaService;
import hexagonal.core.domain.usecase.*;
import hexagonal.ports.in.*;
import hexagonal.ports.out.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public ClienteService servicoCliente(ClienteRepositoryPort repo) {
        return new ClienteService(repo);
    }

    @Bean
    public CreateClienteInputPort createClienteUseCase(ClienteService s) {
        return new CreateClienteUseCase(s);
    }

    @Bean
    public GetClienteInputPort getClienteUseCase(ClienteService s) {
        return new GetClienteUseCase(s);
    }

    @Bean
    public UpdateClienteInputPort updateClienteUseCase(ClienteService s) {
        return new UpdateClienteUseCase(s);
    }

    @Bean
    public DeleteClienteInputPort deleteClienteUseCase(ClienteService s) {
        return new DeleteClienteUseCase(s);
    }

    @Bean
    public JogoPlataformaService servicoJogoPlataforma(JogoRepositoryPort jogoRepo,
                                                       PlataformaRepositoryPort plataformaRepo,
                                                       JogoPlataformaRepositoryPort assocRepo) {
        return new JogoPlataformaService(jogoRepo, plataformaRepo, assocRepo);
    }

    @Bean
    public CreateJogoPlataformaInputPort createJogoPlataformaUseCase(JogoPlataformaService s) {
        return new CreateJogoPlataformaUseCase(s);
    }

    @Bean
    public GetJogoPlataformaInputPort getJogoPlataformaUseCase(JogoPlataformaService s) {
        return new GetJogoPlataformaUseCase(s);
    }

    @Bean
    public UpdateJogoPlataformaInputPort updateJogoPlataformaUseCase(JogoPlataformaService s) {
        return new UpdateJogoPlataformaUseCase(s);
    }

    @Bean
    public DeleteJogoPlataformaInputPort deleteJogoPlataformaUseCase(JogoPlataformaService s) {
        return new DeleteJogoPlataformaUseCase(s);
    }

    @Bean
    public PlataformaService servicoPlataforma(PlataformaRepositoryPort repo) {
        return new PlataformaService(repo);
    }

    @Bean
    public CreatePlataformaInputPort createPlataformaUseCase(PlataformaService s) {
        return new CreatePlataformaUseCase(s);
    }

    @Bean
    public GetPlataformaInputPort getPlataformaUseCase(PlataformaService s) {
        return new GetPlataformaUseCase(s);
    }

    @Bean
    public UpdatePlataformaInputPort updatePlataformaUseCase(PlataformaService s) {
        return new UpdatePlataformaUseCase(s);
    }

    @Bean
    public DeletePlataformaInputPort deletePlataformaUseCase(PlataformaService s) {
        return new DeletePlataformaUseCase(s);
    }
}
