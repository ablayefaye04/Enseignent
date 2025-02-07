package sn.l3l2i.gestionEnseignants.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sn.l3l2i.gestionEnseignants.models.Enseignant;
import sn.l3l2i.gestionEnseignants.repository.EnseignantRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EnseignantServiceTest {

    @Mock
    private EnseignantRepository enseignantRepository;

    @InjectMocks
    private EnseignantService enseignantService;

    @Test
    public void testAjouterEnseignant() {
        Enseignant enseignant = new Enseignant(1L, "FAYE", "Ablaye", "fayeablaye404@gmail.com");

        when(enseignantRepository.save(any(Enseignant.class))).thenReturn(enseignant);

        Enseignant savedEnseignant = enseignantService.ajouterEnseignant(enseignant);

        assertNotNull(savedEnseignant);
        assertEquals("FAYE", savedEnseignant.getNom());
        verify(enseignantRepository, times(1)).save(enseignant);
    }

   /* @Test
    public  void testTrouverenseignant(){
        Enseignant enseignant = new Enseignant(1L,"FAYE","Ablaye","Fayeablaye404@gmail.com");
        when(enseignantRepository.findById(1L)).thenReturn(java.util.Optional.of(enseignant));

        Enseignant foundEnseignant = enseignantService.trouverEnseignantParId(1L);

        assertNotNull(foundEnseignant);
        assertEquals("FAYE", foundEnseignant.getNom());
        verify(enseignantRepository, times(1)).findById(1L);
    }*/
}
