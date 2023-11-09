using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class DemonWaterController : MonoBehaviour
{
    private int EXP = 200;
    public GameObject ElementalSuperDemonWater;
    public Image hpBar;
    private GameObject cleaveWaterObject;
    private ParticleSystem cleaveWaterParticle;

    void Start()
    {
        hpBar.rectTransform.localScale = new Vector3(1f, 1f, 1f);
        ElementalSuperDemonWater.SetActive(true);

        cleaveWaterObject = GameObject.Find("CleaveWater");
        cleaveWaterParticle = cleaveWaterObject.GetComponent<ParticleSystem>();
        StopParticleEffect();
    }

    void Update()
    {

    }

    void OnMouseDown()
    {
        PlayParticleEffect();
        Invoke("DownEXP", 0.5f);
    }

    void StopParticleEffect()
    {
        if (cleaveWaterParticle != null)
        {
            cleaveWaterParticle.Stop();
            cleaveWaterParticle.Clear();
        }
    }

    void PlayParticleEffect()
    {
        if (cleaveWaterParticle != null)
        {
            StopParticleEffect();
            cleaveWaterParticle.Play();
        }
    }

    void DownEXP()
    {
        EXP -= 10;
        Debug.Log("EXP: " + EXP);

        if (EXP <= 0)
        {
            ElementalSuperDemonWater.SetActive(false);
        }

        hpBar.rectTransform.localScale = new Vector3((float)EXP / (float)500, 1f, 1f);
    }
}
