package data_hora_tempo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ProgramaDataHora {
    public static void main(String[] args) {

//        Instanciação de datas

        LocalDate data01 = LocalDate.now(); //Data do dia no momento atual

        LocalDateTime data02 = LocalDateTime.now(); //Data do dia com o tempo no momento atual

        Instant data03 = Instant.now(); //Data do dia com o tempo e o TimeZone padrão no momento atual

        LocalDate data04 = LocalDate.parse("2023-01-01"); //Gerando uma Data atráves de um texto ISO-8601

        LocalDateTime data05 = LocalDateTime.parse("2023-01-01T01:01:59");//Gerando uma Data-Hora atráves de um texto ISO-8601

        Instant data06 = Instant.parse("2023-01-01T01:01:59Z");//Gerando uma Data-Hora usando o Instant e dizendo que é no horario padrao atráves de um texto ISO-8601

        Instant data07 = Instant.parse("2023-01-01T01:01:59-03:00");//Gerando uma Data-Hora usando o Instant e um Fuso horario diferente atráves de um texto ISO-8601

        System.out.println(data01);
        System.out.println(data02);
        System.out.println(data03);
        System.out.println(data04);
        System.out.println(data05);
        System.out.println(data06);
        System.out.println(data07);

//      Texto Formato Customizado

        /* Referecia para formatação de data e hora: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html */

        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data08 = LocalDate.parse("13/06/2023", formato1);
        /* Ou também pode ser passado diretamente , como no exemplo: LocalDate data08 = LocalDate.parse("13/06/2023",  DateTimeFormatter.ofPattern("dd/MM/yyyy"); */
        System.out.println(data08);

        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime data09 = LocalDateTime.parse("13/06/2023 11:30", formato2);
        System.out.println(data09);

        /*Dia , Mes, ano [Horario] separados*/

        LocalDate data10 = LocalDate.of(2023, 06, 13);
        System.out.println(data10);

        LocalDateTime data11 = LocalDateTime.of(2023, 06, 13, 18, 07);
        System.out.println(data11);

//        --------------------------------------------------------------

        /*Convertendo uma Data-Hora para um texto no padrão ISO 8601*/

        // Formatando Data em texto

        LocalDate data001 = LocalDate.parse("2023-06-14");

        DateTimeFormatter formato001 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Formato de dia/mes/ano separado com barra.

        System.out.println(data001.format(formato001)); // chamada apos o objeto formato001 instanciado definindo a formatação
        System.out.println(formato001.format(data001)); // Pode ser chamado dessa forma também com o mesmo resultado da linha acima.
        System.out.println(data001.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //Passando diretamente na data sem instanciar um formato, desse meio após a execução o garbage collector limpara a formatação

        // Formatando Data-Hora em texto

        LocalDateTime data002 = LocalDateTime.parse("2023-06-14T13:56:09");
        DateTimeFormatter formato002 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println(data002.format(formato002));
        System.out.println(formato002.format(data002));
        System.out.println(data002.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        // Formatando um Instant em texto

        Instant data003 = Instant.parse("2023-06-14T13:57:16Z");
        DateTimeFormatter formato003 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault()); // Formataçao necessária para Instant, onde é obrigatorio definir o Timezone(Nesse caso pegando o TimeZone do sitema do usuário onde ele estiver).
        System.out.println(formato003.format(data003)); // Unica forma de conversão em formatação é desse meio. **Observação importante é que após a hora passada ele usa o Fuso horário, no caso do Brasil ele diminiu -03:00 .

//        -------------------------------------------------------------

        /*Convertendo uma Data-Hora global para local*/

        Instant data0001 = Instant.now();
        DateTimeFormatter formato0001 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate resultadodata0001 = LocalDate.ofInstant(data0001, ZoneId.systemDefault());
        System.out.println(resultadodata0001); // Resultado da data no padrão de texto ISO 8601
        System.out.println(resultadodata0001.format(formato0001)); //Resultado com a data no texto formatado

        DateTimeFormatter formato0002 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime resultado0002 = LocalDateTime.ofInstant(data0001, ZoneId.systemDefault());
        System.out.println(resultado0002); // Resultado com o padrão de texto ISO 8601
        System.out.println(formato0002.format(resultado0002)); // Resultado com o texto formato

        // Obtendo dados separados

        System.out.println("Dia: " + resultadodata0001.getDayOfMonth());
        System.out.println("Dia da semana: " + resultadodata0001.getDayOfWeek());
        System.out.println("Dia do ano: " + resultadodata0001.getDayOfYear());
        System.out.println("Mês: " + resultadodata0001.getMonthValue());
        System.out.println("Nome do mês: " + resultadodata0001.getMonth());
        System.out.println("Ano: " + resultadodata0001.getYear());

        System.out.println("Hora: " + resultado0002.getHour());
        System.out.println("Minutos: " + resultado0002.getMinute());
        System.out.println("Segundos: " + resultado0002.getSecond());

        /* Calculos com Data-Hora */

        LocalDate ultimaSemana = data01.minusDays(7);
        System.out.println("ultimaSemana: " + ultimaSemana);

        LocalDate proximaSemana = data01.plusDays(7);
        System.out.println("proximaSemana: " + proximaSemana);

        LocalDateTime ultimaSemanaTime = data02.minusDays(7);
        System.out.println("ultimaSemanaTime: " + ultimaSemanaTime);

        LocalDateTime proximaSemanaTime = data02.plusDays(7);
        System.out.println("proximaSemanaTime: " + proximaSemanaTime);

        Instant ultimaSemanaInstant = data03.minus(7, ChronoUnit.DAYS);
        System.out.println("ultimaSemanaInstant: " + ultimaSemanaInstant    );

        DateTimeFormatter formato00001 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        Instant proximaSemanaInstant = data03.plus(7, ChronoUnit.DAYS);
        System.out.println("proximaSemanaInstant: " + formato00001.format(proximaSemanaInstant));

        // Calculondo a duração com Data-Hora

        LocalDate data1 = LocalDate.now();
        LocalDate lastWeek = data1.minusDays(7);
        Duration duration1 = Duration.between(lastWeek.atStartOfDay(), data1.atStartOfDay());

        LocalDateTime data2 = LocalDateTime.now();
        LocalDateTime lastWeekTime = data2.minusDays(7);
        Duration duration2 = Duration.between(lastWeekTime, data2);

        Instant data3 = Instant.now();
        Instant lastWeekInstant = data3.minus(7, ChronoUnit.DAYS);
        Duration duration3 = Duration.between(lastWeekInstant , data3);

        System.out.println(duration1.toDays());
        System.out.println(duration2.toDays());
        System.out.println(duration3.toDays());

    }
}
