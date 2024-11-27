package view;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import io.undertow.Undertow;

public class WebAppServer {

    public static void main(String[] argv) {
        startWebServer();
    }

    /**
     * Запускает веб-сервер. По окончании работы требуется ручная остановка
     * процесса.
     */
    private static void startWebServer() {
        Undertow.Builder builder = Undertow.builder().addHttpListener(8096, "localhost");
        UndertowJaxrsServer server = new UndertowJaxrsServer().start(builder);
        server.deploy(Singleton.class);
        System.out.println("Сервер запущен: http://localhost:8096/");
    }
}
