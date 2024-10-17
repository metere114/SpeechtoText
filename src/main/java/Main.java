import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.resources.transcripts.types.*;

public final class Main {
    public static void main(String[] args) {

        AssemblyAI client = AssemblyAI.builder()
                .apiKey("")
                .build();

        var params = TranscriptOptionalParams.builder()
                .speakerLabels(true)
                .build();

        // local file:
        /*
        Transcript transcript = aai.transcripts().transcribe(
                new File("./example.mp3"), params);
        */

        //publicly-accessible URL:
        String audioUrl = "https://assembly.ai/sports_injuries.mp3";
        Transcript transcript = client.transcripts().transcribe(audioUrl, params);

        transcript.getUtterances().get().forEach(utterance ->
                System.out.println("Speaker " + utterance.getSpeaker() + ": " + utterance.getText())
        );
    }
}